package fi.haagahelia.mtgcollection.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.mtgcollection.domain.AppUser;
import fi.haagahelia.mtgcollection.domain.AppUserRepository;



@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final AppUserRepository repository;

	@Autowired
	public UserDetailServiceImpl(AppUserRepository userRepository) {
		this.repository = userRepository;
	}
	
	
				//Loads the user by the username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	AppUser curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
}