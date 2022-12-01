package ru.itmo.web.hw4.util;

import ru.itmo.web.hw4.model.Post;
import ru.itmo.web.hw4.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataUtil {
    private static final List<User> USERS = Arrays.asList(
            new User(1, "MikeMirzayanov", "Mike Mirzayanov", User.Color.RED),
            new User(6, "pashka", "Pavel Mavrin", User.Color.BLUE),
            new User(9, "geranazavr555", "Georgiy Nazarov", User.Color.GREEN),
            new User(11, "tourist", "Gennady Korotkevich", User.Color.RED)
    );

    private static final List<Post> POSTS = Arrays.asList(
            new Post(1, "Lorem 025", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias autem ea ipsa natus nisi. Aliquid, atque consectetur consequuntur doloribus error esse facere itaque maiores neque omnis porro possimus, ut veritatis?", 1),
            new Post(2, "Lorem 100", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda autem fuga illo nemo numquam omnis perferendis quaerat, quod suscipit ut. Eligendi error fugit praesentium quae tempore. Ad alias asperiores aspernatur, at, atque corporis dignissimos dolorum eos error esse et excepturi facilis fugiat hic laborum mollitia nam numquam perspiciatis placeat quas repudiandae saepe tempora voluptate! Ad aliquam animi architecto asperiores consequatur debitis deleniti dolor dolore dolorem doloribus dolorum ducimus ea excepturi fugiat fugit hic id illo impedit, ipsum labore libero nam nemo nobis officia officiis perferendis porro quia quo rem repellat saepe sapiente sequi, sunt totam, unde veniam voluptatibus. Minus, qui?", 6)
    );

    public static void addData(HttpServletRequest request, Map<String, Object> data) {
        data.put("users", USERS);
        Collections.sort(POSTS, Collections.reverseOrder());
        data.put("posts", POSTS);
        for (User user : USERS) {
            if (Long.toString(user.getId()).equals(request.getParameter("logged_user_id"))) {
                data.put("user", user);
            }
        }
    }
}
