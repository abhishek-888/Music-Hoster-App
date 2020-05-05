package com.upgrad.musichoster.service.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
//import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;


@Entity @Table(name = "MUSICS")
@NamedQueries({@NamedQuery(name = "MusicEntityByUuid", query = "select m from MusicEntity m where m.uuid = :uuid"),
		@NamedQuery(name = "MusicEntityByid", query = "select m from MusicEntity m where m.id = :id")})
public class MusicEntity implements Serializable {

	@Id @Column(name = "ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "UUID") @Size(max = 64) private String uuid;

	 public String getUuid() {
	        return uuid;
		}
		
		/**
		 * @param uuid the uuid to set
		 */
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

	@Column(name = "MUSIC") private String music;
	
	 public String getMusic() {
	        return music;
		}
		
		/**
		 * @param music the music to set
		 */
		public void setMusic(String music) {
			this.music = music;
		}
	@Column(name = "NAME") private String name;
	 /**
	  * @return the name
	  */
	 public String getName() {
		 return name;
	 }
		
		public void setName(String name) {
			this.name = name;
		}
	@Column(name = "DESCRIPTION") private String description;
	
	 /**
	  * @return the description
	  */
	 public String getDescription() {
		 return description;
	 }
		
		public void setDescription(String description) {
			this.description = description;
		}

	@Column(name = "NO_OF_LIKES") private long no_of_likes;

		/**
		 * @return the no_of_likes
		 */
		public long getNo_of_likes() {
			return no_of_likes;
		}

		/**
		 * @param no_of_likes the no_of_likes to set
		 */
		public void setNo_of_likes(long no_of_likes) {
			this.no_of_likes = no_of_likes;
		}
	@ManyToOne @JoinColumn(name = "USER_ID") private UserEntity user;

		/**
		 * @return the user
		 */
		public UserEntity getUser() {
			return user;
		}

		/**
		 * @param user the user to set
		 */
		public void setUser(UserEntity user) {
			this.user = user;
		}
	@Column(name = "CREATED_AT") private ZonedDateTime created_at;
		/**
		 * @return the created_at
		 */
		public ZonedDateTime getCreated_at() {
			return created_at;
		}

		/**
		 * @param created_at the created_at to set
		 */
		public void setCreated_at(ZonedDateTime created_at) {
			this.created_at = created_at;
		}
	@Column(name = "STATUS") private String status;
	
	 /**
	  * @return the status
	  */
	 public String getStatus() {
		 return status;
	 }
		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}
}
