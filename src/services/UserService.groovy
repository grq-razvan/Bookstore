package services

import groovy.xml.XmlUtil
import models.User

class UserService {

    private static final String PATH_TO_USERS = "resources/users.xml"
    private static final Integer USER_ID = 0;
    private static final Integer USER_PASS = 2;
    private static final Integer USER_ROLE = 3;
    private static final Integer USER_NAME = 1;
    def users
    def usersXmlFile// = new FileInputStream(PATH_TO_USERS)


    UserService() {
        usersXmlFile = new FileInputStream(PATH_TO_USERS)

    }

    private def parse() {
        users = new XmlSlurper().parse(usersXmlFile)
        def userList = new ArrayList<User>()
        users.user.each { node ->
            def user = new User()
            user.id = node.@id.toInteger()
            user.role = node.@role.toInteger()
            user.username = node.@username
            user.password = node.@password
            userList.add(user)
        }
        //userList.each { println it }
        return userList;
    }

    public List<User> getUsers() {
        parse()
    }

    def append(List<String> properties) {
        users = new XmlSlurper().parse(usersXmlFile)
        users.appendNode {
            user(id: properties.get(USER_ID),
                    password: properties.get(USER_PASS),
                    role: properties.get(USER_ROLE),
                    username: properties.get(USER_NAME)
            )
        }
        String result = XmlUtil.serialize(users)
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(PATH_TO_USERS), "utf-8"));
            writer.write(result);
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                //ignore}
            }
        }
    }

    def append(User user) {
        append([user.id.toString(), user.password, user.role.toString(), user.username])
    }

    def delete(Integer userId) {
        users = new XmlParser().parse(usersXmlFile)
        def usersChildren = users.children()
        def usersNode = usersChildren.find { it.@id.toInteger() == userId.intValue() }
        usersChildren.remove(usersNode)
        String result = XmlUtil.serialize(users)
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(PATH_TO_USERS), "utf-8"));
            writer.write(result);
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                //ignore}
            }
        }
    }

    def delete(User user) {
        delete(user.id)
    }

    def modify(Integer originalUserId, List<String> alteredProperties) {
        users = new XmlParser().parse(usersXmlFile)
        def usersChildren = users.children()
        def usersNode = usersChildren.find { it.@id.toInteger() == originalUserId.intValue() }
        usersChildren.remove(usersNode)
        def newUser = new Node(users, 'user',
                [
                        id      : properties.get(USER_ID),
                        password: properties.get(USER_PASS),
                        role    : properties.get(USER_ROLE),
                        username: properties.get(USER_NAME)
                ]
        )
        String result = XmlUtil.serialize(users)
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(PATH_TO_USERS), "utf-8"));
            writer.write(result);
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                //ignore}
            }
        }
    }

    def modify(User originalUser, User modifiedUser) {
        //modify(originalUser.id,)
    }

    User match(String username, String pass) {
        def list = parse()
        for (User user in list) {
            if (user.username == username && user.password == pass) {
                return user
            }
        }
        return null
    }

    boolean isUserValid(String user, String pass) {
        def list = parse()
        for (User u in list) {
            if (u.username == user && u.password == pass) {
                return true;
            }
        }
        return false;
    }


    def isAdmin(User user) {
        def matcher = match(user.username, user.password)
        matcher.role == 1 ? true : false
    }

    def isAdmin(String user, String pass) {
        def matcher = match(user, pass)
        matcher.role == 1 ? true : false
    }
}
