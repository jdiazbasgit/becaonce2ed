class NativeName {
    constructor(traduccionAlIdioma) {
      this.traduccionAlIdioma = traduccionAlIdioma;
    }
  }
  
  class TraduccionAlIdioma {
    constructor(official, common) {
      this.official = official;
      this.common = common;
    }
  }
  
  class Name {
    constructor(common, official, nativeName) {
      this.common = common;
      this.official = official;
      this.nativeName = nativeName;
    }
  }
  class Currencies {
    constructor(moneda) {
      this.moneda = moneda;
    }
  }
  
  class Moneda {
    constructor(name, symbol) {
      this.name = name;
      this.symbol = symbol;
    }
  }
  class Idd {
    constructor(root, suffixes) {
      this.root = root;
      this.suffixes = suffixes;
    }
  }
  
  class Languages {
    constructor(idioma) {
      this.idioma = idioma;
    }
  }
  
  class IdiomaTraducciones {
    constructor(official, common) {
      this.official = official;
      this.common = common;
    }
  }
  
  class Translations {
    constructor(idiomaTraducciones) {
      this.idiomaTraducciones = idiomaTraducciones;
    }
  }
  
  class IdiomaDemonym {
    constructor(f, m) {
      this.f = f;
      this.m = m;
    }
  }
  
  class Demonym {
    constructor(idiomaDemonyms) {
      this.idiomaDemonyms = idiomaDemonyms;
    }
  }
  
  class Maps {
    constructor(googleMaps, openStreetMaps) {
      this.googleMaps = googleMaps;
      this.openStreetMaps = openStreetMaps;
    }
  }
  
  
  class Gini{
      constructor(year){
          this.year=year;
      }
  }
  class Sign{
      constructor(valor){
          this.valo=valor
      }
  
     
  }
  class Car{
      constructor(sings,side){
          this.sings=sings;
          this.side=side
      }
  }
  
  class Flags{
      constructor(png,svg){
          this.png=png;
          this.svg=svg;
      }
  }
  
  class CoatOfArms{
      constructor(png,svg){
          this.png=png;
          this.svg=svg;
      }
  }
  
  class CapitalInfo{
      constructor(latlangs){
          this.latlangs=latlangs;
      }
  }
  
  class PostalCode{
      constructor(format,regex){
          this.format=format;
          this.regex=regex;
      }
  }
  
  class Pais{
      constructor(name,tlds,cca2,ccn3,cca3,cioc,independent,status,unMember,currencies,idd,capitals,altSpellings,region, subregion,languages,translations,latlang,landlocked,borders,area,demonym,flag,maps,population,gini,fifa,car,timezones,continents,startOfWeek,capitalInfo,postalCode)
      {
  
      }
  }
  
  
  traduccionAlIdioma= new TraDuccionAlIdioma("javier Lang","javier");
  nombre=new Name("javier","javier lang",traduccionAlIdioma);
  moneda=new Moneda("javiEuro","J€")
  currencies= new Currencies(moneda)