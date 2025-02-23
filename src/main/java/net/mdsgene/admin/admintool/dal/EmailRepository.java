package net.mdsgene.admin.admintool.dal;

import net.mdsgene.admin.admintool.entities.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}