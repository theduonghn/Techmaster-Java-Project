package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.repository.PublishingCompanyRepository;

@Service
public class PublishingCompanyService {
    @Autowired
    private PublishingCompanyRepository publishingCompanyRepository;
}
