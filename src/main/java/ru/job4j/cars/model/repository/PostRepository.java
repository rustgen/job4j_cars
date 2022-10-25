package ru.job4j.cars.model.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Post;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class PostRepository {

    private static final String POSTS_LAST_DAY = """
            From Post p JOIN FETCH p.car WHERE p.created BETWEEN :fYesterday and :fToday
            """;
    private static final String POSTS_WITH_PHOTO = """
            From Post p JOIN FETCH p.car c WHERE c.photo.size > 0
            """;
    private static final String POSTS_CERTAIN_BRAND = """
            From Post p JOIN FETCH p.car WHERE p.car.model like :fKey
            """;

    private final CrudRepository crudRepository;

    public List<Post> getPostsLastDay() {
        return crudRepository.query(
                POSTS_LAST_DAY, Post.class,
                Map.of("fYesterday", Timestamp.valueOf(LocalDateTime.now().minusDays(1)),
                        "fToday", Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    public List<Post> getPostsWithPhoto() {
        return crudRepository.query(POSTS_WITH_PHOTO, Post.class);
    }

    public List<Post> getPostsCertainBrand(String key) {
        return crudRepository.query(
                POSTS_CERTAIN_BRAND, Post.class,
                Map.of("fKey", "%" + key + "%")
        );
    }
}
