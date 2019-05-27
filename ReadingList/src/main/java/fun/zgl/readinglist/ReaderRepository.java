package fun.zgl.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 读者信息的仓库接口
 *
 * @author zwl
 * @create 2019/5/27
 * @since 1.0.0
 */

// 扩展了JpaRepository会默认实现18个相关方法
public interface ReaderRepository extends JpaRepository<Reader, String> {

}
