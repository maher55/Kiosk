package se.stridsberg.lenaszoo.services;

import org.springframework.stereotype.Service;
import se.stridsberg.lenaszoo.models.Employee;
import se.stridsberg.lenaszoo.models.Feed;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {

    public List<Feed> getFeed() {
        List<Feed> feed = new ArrayList<>();
        feed.add(new Feed("Lejonmat"));
        feed.add(new Feed("Ormmat"));
        return feed;
    }
}
