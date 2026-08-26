package example.practice.model.dto;

public class BoardDto {
    private String phone;
    private int num;
    
    public BoardDto() {
    }

    public BoardDto(String phone, int num) {
        this.phone = phone;
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BoardDto[phone= "+phone+"num= "+num+"]";
    }
}
