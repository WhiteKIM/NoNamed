package hwagae.Nonamed.common.service;

import hwagae.Nonamed.common.model.UserDetail;
import hwagae.Nonamed.user.model.User;
import hwagae.Nonamed.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isEmpty())
            throw new RuntimeException(); //@TODO 추후 적당한 예외로 변경하자

        return new UserDetail(optionalUser.get());
    }
}
