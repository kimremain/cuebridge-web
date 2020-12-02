package com.jcuesoft.cuebridge.auth.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthDTO implements UserDetails{

    /**
     * 
     */
    private static final long serialVersionUID = -1741913838122701153L;
    
    private String idUser;
    
    private String dsPwd;
    
    private String nmUser;

    private String cdTeam;
    
    private String dsUrl;

    private String ynConfirm;

    private String faxNo;
    
    private String noFaxCompany;

    private String cdCompany;
    
    private String ynAdmin;
    
    private String ynScreen;
     
    public AuthDTO(String idUser, String dsPwd)
    {
        this.setIdUser(idUser);
        this.dsPwd = dsPwd;
    }
     
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();   
/*        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADVISOR"));
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));*/
         
        return authorities;
    }
  
    @Override
    public String getPassword() {
        return dsPwd;
    }
  
    @Override
    public String getUsername() {
        return getIdUser();
    }
  
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
  
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
  
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
  
    @Override
    public boolean isEnabled() {
        return true;
    }
/*    public List<Role> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public String getDsPWd() {
        return dsPWd;
    }
    public void setDsPWd(String dsPWd) {
        this.dsPWd = dsPWd;
    }    
    
    */

    public String getNmUser() {
        return nmUser;
    }

    public void setNmUser(String nmUser) {
        this.nmUser = nmUser;
    }

    public String getCdTeam() {
        return cdTeam;
    }

    public void setCdTeam(String cdTeam) {
        this.cdTeam = cdTeam;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }

    public String getYnConfirm() {
        return ynConfirm;
    }

    public void setYnConfirm(String ynConfirm) {
        this.ynConfirm = ynConfirm;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getNoFaxCompany() {
        return noFaxCompany;
    }

    public void setNoFaxCompany(String noFaxCompany) {
        this.noFaxCompany = noFaxCompany;
    }

    public String getCdCompany() {
        return cdCompany;
    }

    public void setCdCompany(String cdCompany) {
        this.cdCompany = cdCompany;
    }

    public String getYnAdmin() {
        return ynAdmin;
    }

    public void setYnAdmin(String ynAdmin) {
        this.ynAdmin = ynAdmin;
    }

    public String getYnScreen() {
        return ynScreen;
    }

    public void setYnScreen(String ynScreen) {
        this.ynScreen = ynScreen;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
}
