package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entitiy.Publisher;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    // Find by id
    public Publisher findById(String id) {
        return publisherRepository.findById(id).orElseThrow(() -> new NotFoundException("No publisher with id = " + id));
    }

    // Find all
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    // Add entity
    public Publisher add(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    // Add instance by request

    // Update instance
    public Publisher update(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    // Update instance by request


    // Delete by id
    public void deleteById(String id) {
        publisherRepository.deleteById(id);
    }
}