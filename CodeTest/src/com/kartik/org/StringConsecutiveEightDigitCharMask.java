package com.kartik.org;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author kmandal
 *
 */
public class StringConsecutiveEightDigitCharMask {
/**
 * 
 * @param data
 * @return
 */
 static String maskValue(String data,int numebrOfDigit) {
  int[] a = new int[data.length()];
  char[] ch = data.toCharArray();
  int k = 0;
  int i = 0;
  for (i = 0; i < ch.length; i++) {
   int temp = i;
   if (isSpecialAndDigit(ch[i])) {
    int countNumber = 0;
    for (int j = i; j < ch.length; j++) {
     if (isDigit(ch[j])) {
      temp = j;
      countNumber = countNumber + 1;
      if (countNumber == numebrOfDigit) {
       a[k] = i;
       k++;
       a[k] = j;
       k++;
      }
     } else if (isSpecialChar(ch[j])) {
      temp = j;
     } else {
      temp = j;
      break;
     }
    }
   } else {
    i = temp;
   }
   i = temp;
  }

  String ccPattern = "(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|"
    + "(?:2131|1800|35\\d{3})\\d{11}|(?:4\\d{3}|5[1-5]\\d{2}|6011|7\\d{3})-?\\d{4}-?\\d{4}-?\\d{4}|3[4,7]\\d{13})";
  String desc = displayMaskValue(data, a, ch);
  if (desc.matches(".*" + ccPattern + ".*")) {
   Pattern compile = Pattern.compile(ccPattern);
   Matcher matcher = compile.matcher(desc);
   matcher.find();
   String masked = matcher.group().replaceAll("[0-9]", "X");
   desc = desc.replaceAll(ccPattern, masked);
  }

  return desc;

 }

 /**
  * @param data
  * @param a
  * @param ch
  * @return
  */
 private static String displayMaskValue(String data, int[] a, char[] ch) {
  StringBuffer br = new StringBuffer();
  int pointer = 0;
  for (int m = 0; m < ch.length; m++) {
   if (isSpecialAndDigit(ch[m])) {
    for (int j = pointer; j < a.length; j++) {
     if (a[j] > 0 && m == a[j]) {
      pointer = pointer + 2;
      if (a[j + 1] > 0) {
       for (int j2 = a[j]; j2 <= a[j + 1]; j2++) {
        if (isDigit(data.charAt(j2))) {
         br.append('X');
        } else {
         br.append(data.charAt(j2));
        }
       }
       m = a[j + 1];
       break;
      }
     } else {
      br.append(ch[m]);
      break;
     }
    }

   } else {
    br.append(ch[m]);
   }
  }
  System.out.println(br.toString());
  return br.toString();
 }

 static boolean isDigit(char c) {
  boolean isDigitAndCharacter = (c >= '0' && c <= '9');
  return isDigitAndCharacter;
 }

 static boolean isSpecialChar(char c) {
  boolean isSpecial = ((c == '!') || (c == '@') || (c == '#')
    || (c == '$') || (c == '&') || (c == '(') || (c == ')')
    || (c == '\\') || (c == '-') || (c == '`') || (c == '+')
    || (c == ',') || (c == '/') || (c == '"') || (c == ' ')|| (c == '_'));
  return isSpecial;
 }

 static boolean isSpecialAndDigit(char ch) {
  boolean isDigitAndCharacter = ((ch >= '0' && ch <= '9') || (ch == '!')
    || (ch == '@') || (ch == '#') || (ch == '$') || (ch == '&')
    || (ch == '(') || (ch == ')') || (ch == '\\') || (ch == '-')
    || (ch == '`') || (ch == '+') || (ch == ',') || (ch == '/') || (ch == '"')|| (ch == '_') || (ch == ' '));
  return isDigitAndCharacter;
 }
 
 public static void main(String[] args) {
	 String data="CAREMARK MAIL 88866RR 823 ,5454334DD 22 SS 7859 980 999  ssn-888-22-7227 IL 123449459580 4444-4444-5555-3333 AA 324-78787676556";
	  System.out.println(data);
	  //here 8 is continious number with special chareter
	  System.out.println(maskValue(data,8));

	}
}



