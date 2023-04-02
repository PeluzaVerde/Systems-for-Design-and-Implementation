package group.lab1FINAL.Service;

import group.lab1FINAL.Model.Employee;
import group.lab1FINAL.Model.Review;
import group.lab1FINAL.Repo.ReviewRepo;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ReviewService implements Service<Review>{

    private ReviewRepo repo;


    public ReviewService(ReviewRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Long> getAll() {
        return repo.findAll().stream().map(review->review.getId()).collect(Collectors.toList());
    }

    public List<Review> getAllDeatils() {

        return repo.findAll();

    }

    @Override
    public Review save(Review obj) {
        return repo.save(obj);
    }

    @Override
    public Review getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Review update(Review obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
