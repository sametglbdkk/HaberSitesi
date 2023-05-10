package Service;



import Repository.AdminRepository;
import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin create(Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }

    public Admin update(Admin updatedAdmin) {
        return adminRepository.save(updatedAdmin);
    }

    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    public Admin getByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    } }

