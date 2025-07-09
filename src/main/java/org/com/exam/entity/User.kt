package org.com.exam.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "user", schema = "exam")
open class User {
    @Id
    @Size(max = 64)
    @Column(name = "user_id", nullable = false, length = 64)
    open var userId: String? = null

    @Size(max = 64)
    @NotNull
    @Column(name = "user_username", nullable = false, length = 64)
    open var userUsername: String? = null

    @Size(max = 64)
    @NotNull
    @Column(name = "user_nickname", nullable = false, length = 64)
    open var userNickname: String? = null

    @Size(max = 64)
    @NotNull
    @Column(name = "user_password", nullable = false, length = 64)
    open var userPassword: String? = null

    @NotNull
    @Column(name = "user_role_id", nullable = false)
    open var userRoleId: Int? = null

    @Size(max = 512)
    @Column(name = "user_avatar", length = 512)
    open var userAvatar: String? = null

    @Size(max = 512)
    @Column(name = "user_description", length = 512)
    open var userDescription: String? = null

    @Size(max = 128)
    @Column(name = "user_email", length = 128)
    open var userEmail: String? = null

    @Size(max = 128)
    @Column(name = "user_phone", length = 128)
    open var userPhone: String? = null

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_time", nullable = false)
    open var createTime: Instant? = null

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "update_time", nullable = false)
    open var updateTime: Instant? = null
}