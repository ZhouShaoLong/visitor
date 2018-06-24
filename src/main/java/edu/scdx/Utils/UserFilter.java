package edu.scdx.Utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Component
public class UserFilter {
    public boolean name_stringFilter(String str) throws PatternSyntaxException {
        String pattern = "^.{1,12}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    public boolean password_stringFilter(String str) throws PatternSyntaxException{
        String pattern = "^[a-zA-Z0-9_]{9,20}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    public boolean address_stringFilter(String str) throws PatternSyntaxException{
        String pattern = "^.{0,100}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    public boolean email_stringFilter(String str) throws PatternSyntaxException{
        String pattern = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    public boolean birthday_stringFilter(String str) throws PatternSyntaxException{
        return true;
    }

    public boolean phone_stringFilter(String str) throws PatternSyntaxException{
        if(str.length()!=11){
            return false;
        }

        String pattern_mobile = "^1((3[0-9]|4[57]|5[0-35-9]|7[0678]|8[0-9])\\d{8}$)";
        String pattern_cm = "^1(3[4-9]|4[7]|5[0-27-9]|7[08]|8[2-478])\\\\d{8}$";
        String pattern_cu = "^1(3[0-2]|4[5]|5[56]|7[0156]|8[56])\\\\d{8}$";
        String pattern_ct = "^1(3[3]|4[9]|53|7[037]|8[019])\\\\d{8}$";

        Pattern mobile = Pattern.compile(pattern_mobile);
        Pattern cm = Pattern.compile(pattern_cm);
        Pattern cu = Pattern.compile(pattern_cu);
        Pattern ct = Pattern.compile(pattern_ct);

        Matcher m_mobile = mobile.matcher(str);
        Matcher m_cm = cm.matcher(str);
        Matcher m_cu = cu.matcher(str);
        Matcher m_ct = ct.matcher(str);

        return m_mobile.matches()||m_cm.matches()||m_cu.matches()||m_ct.matches();
    }

    public boolean qq_stringFilter(String str) throws PatternSyntaxException{
        String pattern = "^[1-9][0-9]{5,9}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

}
