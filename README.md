# weblab4-backend
Web programming lab work 4 backend made at ITMO University by Artem Bakin and Dmitry Kupershtein.

## Task
Develop a **RESTful backend on Spring** that determines whether a point on a coordinate plane falls into a given area. This area has a variable radius R.

All data must be stored using **Oracle DB**.

## ER diagram
![weblab4-back-er](https://user-images.githubusercontent.com/38016689/105633512-0ea26480-5e6a-11eb-9219-1c091a3ce822.png)


## Spring Security roles
| ROLE   |Desc                                                                  | 
| -------|--------------------------------------------------------------------- |
| USER   | Can add entries. Can see and delete only own entries                 |
| ADMIN  | Can see all entries and users. Can delete any user or entry by id.   |

## API description
| Path                         | Method     |Desc                                                    | 
| ---------------------------- | ---------- |------------------------------------------------------- |
| /api/authorization/signup    | POST       | Create new user                                        |
| /api/authorization/signin    | GET        | Sign in for existing user                              |
| /api/authorization/logout    | GET        | Logout and close session                               |
| &#xfeff;                     |            |                                                        |
| /api/entries                 | POST       | Check X Y R for hit and add new entry to database      |
| /api/entries                 | DELETE     | Delete all user's entries                              |
| /api/entries                 | GET        | Get list of all user's entries                         |
| /api/entries/{id}            | GET        | Get entry by id                                        |
| &#xfeff;                     |            |                                                        |
| /api/admin/users             | GET        | Get list of all users                                  |
| /api/admin/entries           | GET        | Get list of all entries in DB                          |
| /api/admin/users/{id}        | DELETE     | Delete user by id                                      |
| /api/admin/entries/{id}      | DELETE     | Delete entry by id                                     |
