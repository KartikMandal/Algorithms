package com.kartik.org;

import java.util.Currency;
import java.util.Locale;

public class CuurencyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub #8377
		
		Currency currency = Currency.getInstance(Locale.JAPAN);
        System.out.println("Japan = " + currency.getSymbol());

        currency = Currency.getInstance(Locale.UK);
        System.out.println("UK = " + currency.getSymbol());

        currency = Currency.getInstance(Locale.US);
        System.out.println("US = " + currency.getSymbol());

        currency = Currency.getInstance(new Locale("in", "ID"));
        System.out.println("Indonesia = " + currency.getSymbol());
        
        Locale indiaLocale = new Locale("hi", "IN");
        currency = Currency.getInstance(indiaLocale);
        
        // get and print the symbol of the currency
        String symbol = currency.getSymbol();
        System.out.println("Currency symbol is = " + symbol);

      //Display properties for language = english & Country = USA
        displayCurrency("en", "US");

        //Display properties for language = french & Country = france
        displayCurrency("fr", "FR");


        //Display properties for language = hindi & Country = india
        displayCurrency("hi", "IN");

        //Display properties for language = russian & Country = russia
        displayCurrency("ru", "RU");
        
        //https://www.mkyong.com/java/display-a-list-of-countries-in-java/
        String [] countries = Locale.getISOCountries();
        String [] languages = Locale.getISOLanguages();
        
        int i;

        System.out.println("\nCountries:\n");
        for (i = 0; i < countries.length; i++)
          System.out.println(countries[i]);
        System.out.println("\nLanguages:\n");
        for (i = 0; i < languages.length; i++)
          System.out.println(languages[i]);
    }

    private static void displayCurrency(String languageCode,
                                        String countryCode) {

        Locale locale = new Locale(languageCode, countryCode);
        Currency currency = Currency.getInstance(locale);
        String code = currency.getCurrencyCode();
        String symbol = currency.getSymbol();

        System.out.printf("Loading currency info for CountryCode=%s,LanguageCode=%s",
                countryCode, languageCode);
        System.out.println();
        System.out.printf("Currency Code=%s, Symbol=%s",code, symbol );

        System.out.println();
        System.out.println();
    }

}
