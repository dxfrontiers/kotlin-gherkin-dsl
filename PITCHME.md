@snap[midpoint text-04 span-100]
# Domain Specific Languages entwerfen mit Kotlin
<hr>
@fa[file-powerpoint](https://gitpitch.com/dxfrontiers/kotlin-gherkin-dsl)
<br>
@fab[github](https://github.com/dxfrontiers/kotlin-gherkin-dsl)
<hr>
## Frank Scheffler
@img[profile-pic span-15](https://pbs.twimg.com/profile_images/1023243380871110656/C2IkwvVv_400x400.jpg)
<br>
@fab[twitter](@maverick_1601)
@snapend

@snap[south-east span-15 text-05 text-right top-right]
@img[](https://www.java-forum-stuttgart.de/_data/JFS-Logo.jpg)
@fa[hashtag](jfs2019)
@snapend

@snap[south text-03 text-left]
@fab[medium](https://blog.digitalfrontiers.de)
<br>
@fa[link](https://www.digitalfrontiers.de)
@snapend

---

@title[Kotlin Introduction]

@snap[north-east span-60]
@img[](assets/img/kotlin_tagcloud.png)
@snapend

@snap[west span-50 fragment]
@quote[Wer hat schon mal mit Kotlin gearbeitet?]
@snapend

+++?code=src/main/kotlin/KotlinImmutabilityNullSafety.kt&lang=kotlin&title=Immutability and Null Safety

@[2](Immutable variable with derived String type)
@[2-3](Immutable variables cannot be reassigned)
@[5](Null cannot be assigned to non-null types)
@[7-8](Nullable yet uninitialized variable)
@[7,9-10](Variable can be accessed after initial assignment)
@[7,9-12](Value can be reassigned even to null)

+++?code=src/main/kotlin/KotlinFunctions.kt&lang=kotlin&title=Everything is fun in Kotlin!

@title[Functions]

@[1-3](Regular function body)
@[5](One line function with inferred return type)
@[7,9](Extension functions for existing classes)
@[11,18](Main function)
@[1-3,12](Calling using positional parameters)
@[5,13](Preferably calling using named parameters)
@[12,14-16](Functional chaining using built-in extension functions)
@[7-9,17](Using custom extension functions)


+++?code=src/main/kotlin/KotlinLambdas01.kt&lang=kotlin&title=Lambdas

@[1-10](Function types as parameters)
@[1,13-16](Calling with pre-defined lambda)
@[18-20](Passing lambdas directly with optional parentheses)

+++?code=src/main/kotlin/KotlinLambdas02.kt&lang=kotlin&title=Lambdas with Generics

@[1-3,6,13](Method return type inferred from Lambda)

+++?code=src/main/kotlin/KotlinLambdas03.kt&lang=kotlin&title=Lambdas with Receiver

@[1-2,4,11](TxContext acting as receiver of the lambda function)

---

@title[DSL Definition 1]

@snap[north-east span-100 text-right]
### Domain Specific Languages
@snapend

@snap[midpoint span-100 text-08 fragment]
@quote[DSLs are small languages, focused on a **particular aspect** of a software system. You can't build a whole program with a DSL, but you often use multiple DSLs in a system mainly written in a general purpose language.](Martin Fowler with Rebecca Parsons)
@snapend

+++

@title[DSL Definition 2]

@snap[north-east span-100 text-right]
### Domain Specific Languages
@snapend

@snap[midpoint span-100 text-08]
@quote[DSLs come in two main forms: **external** and **internal**. An external DSL is a language that's **parsed independently** of the host general purpose language: good examples include regular expressions and CSS.](Martin Fowler with Rebecca Parsons)
@snapend

+++

@title[DSL Definition 3]

@snap[north-east span-100 text-right]
### Domain Specific Languages
@snapend

@snap[midpoint span-100 text-08]
@quote[Internal DSLs are a **particular form of API** in a host general purpose language, often referred to as a **fluent interface**. The way mocking libraries, such as JMock, define expectations for tests are good examples of this](Martin Fowler with Rebecca Parsons)
@snapend

+++?code=src/main/kotlin/DslBoilerPlate.kt&lang=kotlin&title=Reducing Boiler-Plate Code

@[1-9](Database connection/query interface)
@[11-22](Properly cleaning up resources is typical boiler-plate)
@[24-30](Boiler plate can be captured within DSL functions)

+++?code=src/main/kotlin/DslDeclarationExecution.kt&lang=kotlin&title=Separation of Declaration and Execution

@[1-5,8-14]
@[15]

+++

@title[Advantages of DSLs]

@snap[north-east text-03 span-35]
# Advantages of DSLs
@snapend

@snap[north span-25 text-05]
@box[bg-orange text-white rounded box-padding fragment](Predictable#Domain logic is expressed declaratively, while execution is controlled by the DSL.)
@snapend
@snap[west span-25 text-05]
@box[bg-orange text-white rounded box-padding fragment](Safer#Restricted dialect and clearer scoping reduces unsafe operations.)
@snapend
@snap[south span-25 text-05]
@box[bg-orange text-white rounded box-padding fragment](More expressive#Domain code clearly expresses what should be done. Domain specific errors are easier to understand.)
@snapend
@snap[east span-25 text-05]
@box[bg-orange text-white rounded box-padding fragment](Portable#Domain logic execution can be ported to new platforms, if necessary.)
@snapend
@snap[midpoint span-25 text-06]
@box[bg-orange text-white rounded box-padding fragment](Easier to understand#Domain experts are able to learn the DSL in less time.)
@snapend

Note:
- TODO: https://tomassetti.me/domain-specific-languages/


---

@title[A Gherkin Test DSL]

@snap[north-east text-05 span-100]
# A Gherkin Test DSL
@snapend

@snap[south-east span-90 text-06 fragment]
@quote[Gherkin uses a set of special keywords to give structure and meaning to executable specifications.](Cucumber)
@snapend

@snap[west span-27 fragment]
@box[bg-orange text-white waved box-padding](given#state before behavior is applied)
@snapend

@snap[midpoint span-27 fragment]
@box[bg-orange text-white waved box-padding](when#specifies the behavior part)
@snapend

@snap[east span-27 fragment]
@box[bg-orange text-white waved box-padding](then#defines changes or outcome expected)
@snapend


+++?code=src/test/kotlin/de/digitalfrontiers/kotlin/gherkin/CalculatorTest.kt&lang=kotlin&title=The Calculator

@[6-10](Adding numbers)
@[28-39](Classical add number verification)
@[14-24](Gherkin style add number verification)
@[17-19](Given lambda yields the test subject)
@[19-21](When receives the test subject as this and returns any result)
@[21-23](Then receives an Assertion object wrapping the result)
@[15-24]

+++?code=src/main/kotlin/de/digitalfrontiers/kotlin/gherkin/GherkinDsl.kt&lang=kotlin&title=The Gherkin DSL

@[10-11](Capturing the test setup function)
@[10-17](Capturing test execution result)
@[17-21](Triggering test and assertion)

+++

@title[Repeated Test Execution]
Repeated Test Execution

```kotlin
    @Test
    fun `provides random multiples in range (repeatedly)`() {
        given {
            Calculator()
        }.on(repeat = 100) {
            randomMultiple(9)
        }.thenAssert {
            isBetween(1, 100)
        }
    }
```

+++?code=src/test/kotlin/de/digitalfrontiers/kotlin/gherkin/GreeterTest.kt&lang=kotlin&title=The Infamous Greeter

@[6-16](Locale aware greeting)
@[18-32](Gherkin style greeting verification)
@[26-30](Fluent string verification syntax)

+++?code=src/main/kotlin/de/digitalfrontiers/kotlin/gherkin/GherkinDsl.kt&lang=kotlin&title=The Gherkin DSL

@[32-34,37-39](Fluent syntax using infix functions)
@[17,23-39](Assertion scope with infix functions)
@[37-47](Sample string based asserter)
@[42-61]

+++

### Kotlin DSL Building Blocks

@ol
- Capturing declarations using Lambdas
- Contexts using Lambdas with Receivers
- Scoped extension functions (should)
- Infix notation for improved readability
@olend

+++

@title[Existing Kotlin DSL Overview]

@snap[north-west span-45 text-05]
@box[bg-orange text-white rounded box-padding](https://github.com/gradle/kotlin-dsl#Gradle Kotlin DSL)
@snapend

@snap[north-east span-45 text-05]
@box[bg-orange text-white rounded box-padding](https://github.com/kotlintest/kotlintest#Kotlin Test)
@snapend

@snap[west span-45 text-05]
@box[bg-orange text-white rounded box-padding](https://github.com/spring-projects/spring-framework#Beans/Router/MockMvc DSL)
@snapend

@snap[east span-45 text-05]
@box[bg-orange text-white rounded box-padding](https://github.com/spring-projects/spring-fu#Spring Fu Microframework)
@snapend

@snap[south-west span-45 text-05]
@box[bg-orange text-white rounded box-padding](https://www.kotlinresources.com/library/kuery/#Kuery SQL in Kotlin)
@snapend

@snap[south-east span-45 text-05]
@box[bg-orange text-white rounded box-padding](https://github.com/dxfrontiers/kotlin-geojson-dsl#GeoJSON Builder DSL)
@snapend

---

@title[Final Question]

@snap[north-east text-09 span-60]
Wofür werden Sie morgen eine **Kotlin DSL** erstellen
@fa[question fa-spin]
@snapend

+++

@title[The End]

@snap[north-east text-09 span-60]
Wofür werden Sie morgen eine **Kotlin DSL** erstellen
@fa[question fa-spin]
@snapend

@snap[midpoint text-04 span-100]
# Domain Specific Languages entwerfen mit Kotlin
<hr>
@fa[file-powerpoint](https://gitpitch.com/dxfrontiers/kotlin-gherkin-dsl)
<br>
@fab[github](https://github.com/dxfrontiers/kotlin-gherkin-dsl)
@snapend

@snap[south-west span-50 text-03 text-left]
@img[profile-pic span-30](https://pbs.twimg.com/profile_images/1023243380871110656/C2IkwvVv_400x400.jpg)
<br>
@fab[twitter](@maverick_1601)
<br>
@fab[github](https://github.com/maverick1601)
<br>
@fa[linkedin](https://bit.ly/2EDAagi)
<br>
@fa[xing](https://bit.ly/2ECRIJt)
@snapend

@snap[south-east span-50 text-03 text-right]
@img[span-30](assets/img/logo.png)
<br>
@fab[twitter](@dxfrontiers)
<br>
@fab[medium](https://blog.digitalfrontiers.de)
<br>
@fa[link](https://www.digitalfrontiers.de)
<br>
@fa[hashtag](WeAreHiring)
@snapend

---

@title[Teaser]

@snap[north text-04 span-100]
<br><br><br>
# Domain Specific Languages entwerfen mit Kotlin
<hr>
## Frank Scheffler
@snapend

@snap[south span-25 text-04]
@img[profile-pic](https://pbs.twimg.com/profile_images/1023243380871110656/C2IkwvVv_400x400.jpg)
<br>
@fab[twitter](@maverick_1601)
@snapend

@snap[south-east span-25]
@img[](assets/img/Button_speaker_2019.jpg)
@snapend

@snap[south-west span-27]
@img[](assets/img/kotlin_tagcloud.png)
@snapend

