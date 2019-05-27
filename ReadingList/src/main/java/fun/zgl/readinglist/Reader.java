package fun.zgl.readinglist;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

/**
 * 代表读者的实体类
 *
 * @author zwl
 * @create 2019/5/27
 * @since 1.0.0
 */

@Entity
public class Reader implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;

    private String fullname;
    private String password;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // UserDetails Methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 简单的权限生成方式
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    // 不过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 不加锁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 不禁用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
