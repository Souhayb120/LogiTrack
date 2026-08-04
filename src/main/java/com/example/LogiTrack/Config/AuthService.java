package com.example.LogiTrack.Config;




import com.example.LogiTrack.DTO.AuthResponse;
import com.example.LogiTrack.DTO.UserAuthRequest;
import com.example.LogiTrack.Models.Admin;
import com.example.LogiTrack.Models.Agent;
import com.example.LogiTrack.Models.Manager;
import com.example.LogiTrack.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UserService userDetailsService;
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public void register(UserAuthRequest request) {
        Manager manager = new Manager();
        Agent agent = new Agent();
        Admin admin = new Admin();
        switch (request.getRole().name()) {
            case "MANAGER" -> {
                manager.setUserName(request.getUserName());
                manager.setEmail(request.getEmail());
                manager.setRole(request.getRole());
                manager.setPassword(passwordEncoder.encode(request.getPassword()));
                userRepository.save(manager);
            }
            case "AGENT" -> {
                agent.setUserName(request.getUserName());
                agent.setEmail(request.getEmail());
                agent.setPassword(passwordEncoder.encode(request.getPassword()));
                agent.setRole(request.getRole());
                userRepository.save(agent);
            }
            case "ADMIN" -> {
                admin.setUserName(request.getUserName());
                admin.setEmail(request.getEmail());
                admin.setPassword(passwordEncoder.encode(request.getPassword()));
                admin.setRole(request.getRole());
                userRepository.save(admin);
            }
        }


    }

    public AuthResponse login(UserAuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        UserDetails user = userDetailsService.loadUserByUsername(request.getUserName());
        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }


}
