package vn.techmaster.bookonline.service;

import com.sun.xml.bind.v2.model.runtime.RuntimeArrayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.repository.RatingRepository;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
}
