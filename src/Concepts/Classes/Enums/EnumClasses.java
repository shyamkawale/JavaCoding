package Concepts.Classes.Enums;

public class EnumClasses {
    public enum EnumSample{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THRUSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
    }

    public enum EnumWithCustomValues {
        MONDAY(101, "1st Day Of the Week"),
        TUESDAY(102, "2nd Day Of the Week"),
        WEDNESDAY(103, "3rd Day Of the Week"),
        THRUSDAY(104, "4th Day Of the Week"),
        FRIDAY(105, "5th Day Of the Week"),
        SATURDAY(106, "6th Day Of the Week"),
        SUNDAY(107, "7th Day Of the Week");
    
        private int value;
        private String comment;
    
        EnumWithCustomValues(int value, String comment) {
            this. value = value;
            this. comment = comment;
        }
    
        public int getValue () {
            return value;
        }
    
        public void setValue(int value) {
            this.value = value;
        }
    
        public String getComment() {
            return comment;
        }
    
        public void setComment(String comment) {
            this. comment = comment;
        }
    
        public static EnumWithCustomValues getEnumFromValue(int value){
            for(EnumWithCustomValues enumWithCustomValue : EnumWithCustomValues.values()){
                if(enumWithCustomValue.value == value){
                    return enumWithCustomValue;
                }
            }
            return null;
        }
    }
}
