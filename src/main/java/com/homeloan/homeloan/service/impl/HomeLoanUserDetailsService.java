package com.homeloan.homeloan.service.impl;

/*

@Service
@Slf4j
public class HomeLoanUserDetailsService implements UserDetailsService {

    @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(getUserList().contains(username)){
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();

            try {
             UserDetailResponse response =getUserDetail(username);
             if(Objects.nonNull(response)){
                 response.getRoles().forEach(s->{
                     authorities.add(new SimpleGrantedAuthority(s.getRoleKey()));
                 });
             }
            } catch (Exception e) {
                log.error("Exception while fetching user details:",e);
            }
               return new User(username, "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",authorities);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private List<String> getUserList(){
        ArrayList<String> usersList= new ArrayList<>();
        usersList.add("thorsten-a.merkel@db.com");
        usersList.add("ranvijay.singh@db.com");
        usersList.add("sonu.yadav@db.com");
        usersList.add("hitendra.kumar@db.com");
        return usersList;
    }

    public UserDetailResponse getUserDetail(String emailId) throws Exception {
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        ArrayList<RoleDetail> roles = new ArrayList<>();
        //check in approver table
        ApproverUser response = approverUserRepo.findByEmail(emailId);

        if (!Objects.isNull(response)) {
            userDetailResponse.setUserId(response.getApproverUserId());
            BeanUtils.copyProperties(response, userDetailResponse);

            if (response.getApproverUserGroup() != null) {
                response.getApproverUserGroup().forEach(approverUserGroup -> {
                    RoleDetail role = new RoleDetail();
                    approverUserGroup.getApproverGroup().getApproverGroupRole().forEach(approverGroupRole -> {

                        if (CollectionUtils.isNotEmpty(roles)) {
                            roles.forEach(roleObject -> {
                                if (roleObject.getRoleKey() != approverGroupRole.getUamRole().getRoleKey()) {
                                    BeanUtils.copyProperties(approverGroupRole.getUamRole(), role);
                                    roles.add(role);
                                }
                            });
                        } else {
                            BeanUtils.copyProperties(approverGroupRole.getUamRole(), role);
                            roles.add(role);
                        }
                    });
                });
            }
            //check for admin
            if (response.isAdmin()) {
                RoleDetail role = new RoleDetail();
                role.setRoleKey(ConstantUtils.ADMIN_ROLE);
                roles.add(role);
            }
            userDetailResponse.setRoles(roles);
        }

        //assign user role
        if (CollectionUtils.isEmpty(userDetailResponse.getRoles())) {
            RoleDetail role = new RoleDetail();
            role.setRoleKey(ConstantUtils.USER_ROLE);
            roles.add(role);
            userDetailResponse.setRoles(roles);
            userDetailResponse.setEmail(emailId);
        }

        return userDetailResponse;
    }

}*/
