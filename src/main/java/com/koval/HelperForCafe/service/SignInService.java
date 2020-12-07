package com.koval.HelperForCafe.service;

import com.koval.HelperForCafe.entity.Person;
import com.koval.HelperForCafe.repository.PersonRepository;
import com.koval.HelperForCafe.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class SignInService implements UserDetailsService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Person> opPerson = personRepository.findByLogin(login);

        if (opPerson.isPresent())
            return opPerson.get();

        throw new UsernameNotFoundException("Пользователь с логином " + login + " несуществует");
    }

    /**
     * Метод сохраняющий новых пользователей в бд
     *
     * @param p
     * @return
     */
    public boolean savePerson(Person p){
        Optional<Person> opPerson = personRepository.findByLogin(p.getLogin());

        if (!opPerson.isPresent()) {
            throw new UsernameNotFoundException("Пользователь с логином " + p.getLogin() + " уже сущетсвует");
        }

        p.setRole(roleRepository.findByName("ROLE_CLIENT").get());
        p.setPassword(passwordEncoder.encode(p.getPassword()));
        personRepository.save(p);
        return true;
    }
}
