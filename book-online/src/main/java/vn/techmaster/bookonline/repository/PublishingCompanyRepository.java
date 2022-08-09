package vn.techmaster.bookonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookonline.entitiy.PublishingCompany;

public interface PublishingCompanyRepository extends JpaRepository<PublishingCompany, String> {
}