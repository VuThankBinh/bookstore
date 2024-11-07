package com.bnpstudio.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bnpstudio.bookstore.entity.SachEntity;

@Repository
public interface SachRepository extends JpaRepository<SachEntity, Integer> {
    // JpaRepository đã có sẵn các phương thức CRUD cơ bản
    // Không cần định nghĩa getAllSach() nữa vì có thể dùng findAll()
    List<SachEntity> findAll();
    SachEntity findById(int id);
    SachEntity save(SachEntity sach);
    void delete(SachEntity sach);
}
