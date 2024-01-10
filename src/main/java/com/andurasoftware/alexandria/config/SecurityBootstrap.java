package com.andurasoftware.alexandria.config;

import com.andurasoftware.alexandria.business.infra.cript.EncryptHelper;
import com.andurasoftware.alexandria.business.security.shared.valueobjects.SecurityRole;
import com.andurasoftware.alexandria.business.security.write.repositories.base.UserRepository;
import com.andurasoftware.alexandria.business.security.write.states.UserState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class SecurityBootstrap implements ApplicationListener<ApplicationReadyEvent> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;
    private final Environment env;

    private final EncryptHelper encryptHelper;

    @Autowired
    public SecurityBootstrap(UserRepository userRepository, Environment env, EncryptHelper encryptHelper) {
        this.userRepository = userRepository;
        this.env = env;
        this.encryptHelper = encryptHelper;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("Verifying if default user exists");
        createUserWithRole(
                env.getProperty("spring.application.admin.name"),
                env.getProperty("spring.application.admin.email"),
                env.getProperty("spring.application.admin.password"),
                SecurityRole.valueOf(env.getProperty("spring.application.admin.role")));
    }

    private void createUserWithRole(String name, String email, String password, SecurityRole authority) {
        if (userRepository.findByEmail(email) != null) {
            return;
        }

        UserState user = new UserState();
        user.setId(UUID.randomUUID());
        user.setName(name);
        user.setEmail(email);
        user.setPassword(this.encryptHelper.encryptPassword(password));
        user.setVersion(new Date());
        user.setEnabled(true);
        user.setRole(authority);

        userRepository.save(user);
    }
}
