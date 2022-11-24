package com.shixi.heima_mm.TODO;

import com.shixi.heima_mm.pojo.UserAdmin;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Configuration
public class UserAdminAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        HttpServletRequest request;
        //管理员名
        String name = "anonymous";
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            request = requestAttributes.getRequest();
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("userAdmin");
            if (obj instanceof UserAdmin) {
                UserAdmin userAdmin = (UserAdmin) obj;
                name = userAdmin.getName();
            }
        }
        return Optional.of(name);
    }
}
