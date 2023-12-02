package model.bean;

public class Role {
    private String idRole;
    private String roleName;

    public Role(String idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
