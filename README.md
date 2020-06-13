# Easy Alert Android
![cover](https://sun1-20.userapi.com/Ul-bsq508DLLxHFjLb6uTDigrdB1CTDHPUT-ZQ/42r0HxShlBM.jpg)

<p align="center">This library should help you create beautiful alerts for Android. Make it easy and fast</p>

---
[![](https://jitpack.io/v/kirvigen/EasyAlert.svg)](https://jitpack.io/#kirvigen/EasyAlert)

# Install

```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the following line to your dependencies:
```groovy
dependencies {
	implementation 'com.github.kirvigen:EasyAlert:0.1.0'
}
```

# Example
## Simple
<img src="https://sun1-90.userapi.com/13h490YGn8AbLdinz0j0DWSVn4m8tzYyDIGFyg/F8mG53q0Hg4.jpg" width="250px" />

```kotlin
  EasyAlert(this).setTitle("Warning!").setTextBody("This is simple Alert")
                .setNeutral("Ok",
                    {a->a.dismiss()},
                   Color.parseColor("#4988f4"))
                .show()
```
## Buttons

Using Negative and Positive buttons.

<img src="https://sun1-85.userapi.com/_Bd4vNbdCct4i4oHbX-rjAqWf-VgzWPVP0FUMA/QoWZ4KHJ9JU.jpg" width="250px" />

```kotlin
   EasyAlert(this).setTitle("Warning!").setTextBody("This is medium Alert")
                .setPositive("Yes!") { a-> a.dismiss()}
                .setNegative("No!"){a->a.dismiss()}
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
```
## ImageRes

Image from resources in top alert

<img src="https://sun1-91.userapi.com/8wlWCWGdbi-yreXmWP86ZUTGTwYlsDLMWZ-PzQ/_fTSpBL-LDw.jpg" width="250px" />

```kotlin
 EasyAlert(this).setTopImage(R.drawable.image)
                .setTitle("Warning!").setTextBody("You can show image resource in top alert.")
                .setPositive("Yes!") { a-> a.dismiss()}
                .setNegative("No!"){a->a.dismiss()}
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
 ```
 ## ImageUrl

Image from url in top alert

<img src="https://sun1-30.userapi.com/gkxcWbViC1Oo1DegGTwTk9l6Vn3G4PJis2NM6w/b0DC7PaRVb4.jpg" width="250px" />

```kotlin
EasyAlert(this).setTopImage("https://avatars.mds.yandex.net/get-pdb/1964870/f271cd11-8868-4bcd-93e7-e911d2254a90/s1200")
                .setTitle("Warning!").setTextBody("You can show image from internet in top alert.")
                .setPositive("Yes!") { a-> a.dismiss()}
                .setNegative("No!"){a->a.dismiss()}
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
 ```
## EditText

<img src="https://sun1-26.userapi.com/YRjoBSuRieEQiyvu8maiqH7a-hEUKgOSpH4qTw/Apz0YP3h01I.jpg" width="250px" />

```kotlin
 EasyAlert(this)
                .setTitle("Warning!").setTextBody("Please enter your Name")
                .setEditText("Name")
                .setPositive("Send") { a-> a.dismiss()
                        Toast.makeText(this,"Your Name is \"${a.inputText}\"",Toast.LENGTH_LONG).show()
                }
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
 ```
 
## ListItems

<img src="https://sun1-97.userapi.com/vmonr9x5EdAuZ1VAFGbB3PHNpb44JACH-pGb4Q/1KFE8kDdGqU.jpg" width="250px" />

```kotlin
 val colors = arrayOf("Red","Green","Blue")
            EasyAlert(this)
                .setTitle("Choose").setTextBody("Do choose your favorite color")
                .setListItems(colors){a,position->
                    a.dismiss()
                    Toast.makeText(this,colors[position],Toast.LENGTH_LONG).show()
                }
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
 ```
 ## Combination
 
 <img src="https://sun1-89.userapi.com/iZqIRVriDN23mdyWGwSbUDxhj1IQCU7v2oLnzw/hf3rpauGFmg.jpg" width="250px" />

```kotlin
EasyAlert(this)
                .setTopImage(R.drawable.image)
                .setTitle("This is combination!").setTextBody("Please enter your Name")
                .setEditText("Name")
                .setPositive("Send") { a-> a.dismiss()
                    Toast.makeText(this,"Your Name is \"${a.inputText}\"",Toast.LENGTH_LONG).show()
                }
                .setNegative("I don`t enter my name"){
                    a->a.dismiss()
                }
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
 ```
 
License
--------

    Copyright 2020 kirvigen, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 
