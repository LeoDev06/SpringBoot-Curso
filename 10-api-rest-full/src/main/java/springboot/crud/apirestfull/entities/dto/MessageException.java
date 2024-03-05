package springboot.crud.apirestfull.entities.dto;

public class MessageException {

   private Integer code;
   private String status;
   private String descripton;

   public MessageException() {
   }

   public Integer getCode() {
      return code;
   }

   public void setCode(Integer code) {
      this.code = code;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getDescripton() {
      return descripton;
   }

   public void setDescripton(String descripton) {
      this.descripton = descripton;
   }
}
