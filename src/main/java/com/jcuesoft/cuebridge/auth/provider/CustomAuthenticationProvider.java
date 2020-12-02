package com.jcuesoft.cuebridge.auth.provider;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.jcuesoft.cuebridge.auth.service.AuthService;
import com.jcuesoft.cuebridge.auth.vo.AuthDTO;
import com.jcuesoft.cuebridge.auth.vo.AuthRequestVO;
import com.jcuesoft.cuebridge.auth.vo.AuthResponseVO;
import com.jcuesoft.cuebridge.common.module.CommonUtil;

/*@Component*/
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    private AuthService authService;
    
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
  
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.debug("Call CustomAuthenticationProvider Authentication");
        UsernamePasswordAuthenticationToken token = null;
        String idUser = (String)authentication.getPrincipal();    
        String dsPwd = (String)authentication.getCredentials();
        
        String tokenIdUser = "";
        String tokenDsPwd = "";
        List<GrantedAuthority> tokeRoles = new ArrayList<GrantedAuthority>();
        
        logger.debug("authenticate parameter:. {}", idUser + "/" + dsPwd);
        
        try {
            AuthRequestVO authRequestVO = new AuthRequestVO();
            AuthResponseVO authResponseVO = new AuthResponseVO();
            String dsPwdMD5 = new CommonUtil().getEncryptMd5(dsPwd);
            
            authRequestVO.setIdUser(idUser);
            authRequestVO.setYnLoginByLincus("N");
            authRequestVO.setDsPwd(dsPwdMD5);
            authResponseVO = authService.getUserInfoByDsPwd(authRequestVO);
            
            if(authResponseVO == null){
                logger.error("no result record! Authentication validate fail! throw BadCredentialsException {}", idUser + "/" + dsPwd);
                throw new BadCredentialsException("Bad credentials");                
            }else if(!dsPwdMD5.equals(authResponseVO.getDsPwd())){
                logger.error("no match password! Authentication validate fail! throw BadCredentialsException {}", idUser + "/" + dsPwd);
            }else{
                logger.debug("correct userinfo, begin login");
            }
            
            tokenIdUser = authResponseVO.getIdUser();
            tokenDsPwd = authResponseVO.getDsPwd();
            tokeRoles.add(new SimpleGrantedAuthority(authResponseVO.getCdRoleApply()));  
            
            if(tokenIdUser != null && tokenIdUser.getBytes().length > 0){
                logger.debug("Authentication validate success! create token!");          
                token = new UsernamePasswordAuthenticationToken(tokenIdUser, tokenDsPwd, tokeRoles);
                token.setDetails(new AuthDTO(idUser, dsPwd));
            }else{
                logger.error("Authentication validate fail! throw BadCredentialsException {}", idUser + "/" + dsPwd);
                throw new BadCredentialsException("Bad credentials");
            }
            
        } catch (Exception e) {
            logger.error("Authentication exception", e);;
        }

        return token;        
    }

}
