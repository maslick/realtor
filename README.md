# =realtor=
 * contains a real estate broker regression model
 * uses [Klassy](https://github.com/maslick/klassy) weka wrapper

See [this article](https://www.ibm.com/developerworks/library/os-weka1/index.html) for more details

## Installation
 * Import ``realtor.jar`` into your project
 * Add Klassy as dependency
```
repositories {
    jcenter()
}
...
dependencies {    
    compile('com.maslick.ai:klassy:0.1.8')
}
```

## Usage
```java
Houser model = new Houser(new ContextLoader());
House house = House.builder()
        .houseSize(2983)
        .lotSize(9365)
        .bedrooms(5)
        .granite(0)
        .bathroom(1)
        .build();

String klass = model.classify(house);
Double cost = Double.valueOf(klass);  // = 222921 dollars
```
