package com.kartik.org;

import java.util.GregorianCalendar;

public class DatePalindrome {

  public static void main(String[] args) {
  String date = "1001/10/01";
  System.out.println("Enter date is --"+date);
  System.out.println("----->>>Given Date previous Palindrome<<<--- ");
  System.out.println("YYYY/DD/MM");
  findPrevDate(date);
  System.out.println("----->>>Given Date Next Palindrome<<<--- ");
  System.out.println("YYYY/DD/MM");
  findNextDate(date);
 }

  static void findPrevDate(String input) {
  int year = extractYear(input); // Extract first 4 digits
  --year;
  // limit is 101 because 0000 will not give you valid month and day.
  for (; year >= 101; --year) {
   if (hasPalindromic(year)) {
    writeDate(year);
   }
  }
 }

  static void findNextDate(String input) {
  int year = extractYear(input);
  --year;
  for (; year <= 9999; ++year) {
   if (hasPalindromic(year)) {
    writeDate(year);
   }
  }
 }

  static boolean hasPalindromic(int year) {
  int first2 = year % 100;
  int last2 = year / 100;
  boolean second_valid = false;
  boolean first_valid = false;

   switch (last2) {
  case 10:
  case 20:
  case 30:
  case 40:
  case 50:
  case 60:
  case 70:
  case 80:
  case 90:
  case 1:
  case 11:
  case 21:
   second_valid = true;
   break;
  }
  if (!second_valid)
   return false;

   switch (first2) {
  case 10:
  case 20:
  case 30:
  case 40:
  case 50:
  case 60:
  case 70:
  case 80:
  case 90:
  case 1:
  case 11:
  case 21:
  case 31:
  case 41:
  case 51:
  case 61:
  case 71:
  case 81:
  case 91:
  case 2:
  case 12:
  case 22:
  case 32:
  case 42:
  case 52:
  case 62:
  case 72:
  case 82:
  case 92:
  case 3:
  case 13:
   first_valid = true;
   break;
  }

   if (!first_valid)
   return false;

   // reverse digit such that 2 yields 20
  int month = reverseDigitsOn100(last2);
  int day = reverseDigitsOn100(first2);

   GregorianCalendar cal = (GregorianCalendar) GregorianCalendar
    .getInstance();
  if (month == 2) {
   if (day <= 28)
    return true;
   if (cal.isLeapYear(year) && day == 29)
    return true;
   if (day > 28)
    return false;
  }

   switch (month) {
  case 4:
  case 6:
  case 9:
  case 11:
   if (day > 30)
    return false;
  }
  // For remaining months, check is already made as first part of year is
  // gives day in range of [1..31].
  return true;
 }

  static int reverseDigitsOn100(int n) {
  int r = 0;

   if (n == 0)
   return 0;

   r = r * 10;
  r = r + n % 10;
  reverseDigitsOn100(n / 10);
  return r;
 }

  static long reverse(int number) {
  int reversedNumber = 0;
  int temp = 0;

   while (number > 0) {
   temp = number % 10;
   reversedNumber = reversedNumber * 10 + temp;
   number = number / 10;
  }
  return reversedNumber;
 }

  static int extractYear(String input) {

   return Integer.parseInt(input.substring(0, 4));
 }

  static void writeDate(int input) {
  long rev = reverse(input);
  String reverseYear = String.valueOf(rev);
  if (String.valueOf(input).length() < 4) {
   reverseYear = reverseYear + "0";
  }
  if (reverseYear.length() < 4) {
   reverseYear = "0" + reverseYear;
  }
  String dd = reverseYear.substring(0, 2);
  String mm = reverseYear.substring(2, 4);
  StringBuffer br = new StringBuffer();
  br.append(input);
  br.append('/');
  br.append(dd);
  br.append('/');
  br.append(mm);
  
  System.out.println(br.toString());
 }

}

