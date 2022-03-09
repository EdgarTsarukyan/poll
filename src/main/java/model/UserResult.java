package model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

public class UserResult {

   private int id;
   private String userEmail;
   private Time createTime;
   private int resultId;

   public UserResult() {
   }

   public UserResult(int id, String userEmail, Time createTime, int resultId) {
      this.id = id;
      this.userEmail = userEmail;
      this.createTime = createTime;
      this.resultId = resultId;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUserEmail() {
      return userEmail;
   }

   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }

   public Time getCreateTime() {
      return createTime;
   }

   public void setCreateTime(Time createTime) {
      this.createTime = createTime;
   }

   public int getResultId() {
      return resultId;
   }

   public void setResultId(int resultId) {
      this.resultId = resultId;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserResult that = (UserResult) o;
      return id == that.id && resultId == that.resultId && Objects.equals(userEmail, that.userEmail) && Objects.equals(createTime, that.createTime);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, userEmail, createTime, resultId);
   }

   @Override
   public String toString() {
      return "UserResult{" +
              "id=" + id +
              ", userEmail='" + userEmail + '\'' +
              ", createTime=" + createTime +
              ", resultId=" + resultId +
              '}';
   }
}
