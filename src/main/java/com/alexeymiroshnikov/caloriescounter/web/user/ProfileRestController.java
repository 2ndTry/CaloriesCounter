package com.alexeymiroshnikov.caloriescounter.web.user;

import com.alexeymiroshnikov.caloriescounter.model.User;

import static com.alexeymiroshnikov.caloriescounter.web.SecurityUtil.authUserId;

public class ProfileRestController extends AbstractUserController {

            public User get() {
                return super.get(authUserId());
            }

            public void delete() {
                super.delete(authUserId());
            }

            public void update(User user) {
                super.update(user, authUserId());
            }
}
