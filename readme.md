# Presentation Mobile Development
## Motivation & Information
This repository was made during a lecture (Mobile Application Development) at the University of applied Sciences Munich. 
This is intended to bring the subject of LiveData closer to the students. It's created by an student, so it might not be suitable as reference, but is designed as orientation for working with LiveData in Android Projects.

The personal motivation was to make it easier for other students to work with LiveData.
Core concepts i want to share are:
* What is LiveData
* Where is LiveData used in an App / How to use LiveData
* some Hints for working with LiveData

## LiveData
The Base concept of LiveData can be read on the official Documentation of Android aswell. I highly recomend, to read the article, before working with LiveData.
[LiveData by the android docs](https://developer.android.com/topic/libraries/architecture/livedata)
The following will explain the Basics also.

### Observer-pattern
This UML-Diagram shows the basic idea of the Observer Pattern.
LiveData would be the Subject in this case and someone (observer) can observe the LiveData's information.
![Observer UML](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Observer_w_update.svg/750px-Observer_w_update.svg.png)

[read more about the Observer Pattern](https://en.wikipedia.org/wiki/Observer_pattern)

### Lifecycle awareness
LiveData will "notify" observers only when their LifeCycle is not in a Dead-State or PAUSED.
LifeCycles are provided usually by Activities and Fragments. 
Thats why passing a LifeCycle is mandatory to observe LiveData.
The only exception is the "Observe forever" method, which can be used without a LifeCycle.

[read more about LifeCycles](https://developer.android.com/topic/libraries/architecture/lifecycle)

### Code examples
#### Create MutableLiveData
> val liveData = MutableLiveData<String>().apply{ value = "Hello World" }
#### create not mutbale LiveData 
  
>@Query("SELECT * FROM PERSON ORDER BY NAME")  
>LiveData<List<Person>> loadAllPersons();
  
#### combine Mutable and immutable LiveData
>//dont let anyone see the MutableLifeData   
private val privateLiveData = MutableLiveData<String>().apply{
			value = "Hello World"
			}  
  //show not mutable LiveData only  
			val publicLiveData : LiveData<String> = privateLiveData	  
  //to edit the LiveData's value, use the visible method  
			fun changeString(string : String){
			privateLiveData.postValue(string)
			}
#### observe LiveData
> //create an observer:  
  val nameObserver = Observer<String> { newName ->  
  &nbsp;&nbsp;&nbsp;&nbsp;
  //assign your observed value, to a view element  
  &nbsp;&nbsp;&nbsp;&nbsp;
  nameTextView.text = newName  
    		}  
			currentName.observe(lifeCycleOwner, nameObserver)  
##### observing LiveData indirectly
> // not observed  
			val name = repository.currentName  
			// make line above observing indirectly  
			val nameLetters = name.observe(lifeCycleOwner,Observer{  
      &nbsp;&nbsp;&nbsp;&nbsp;
			it.toCharArray().asList()  
			}  
	
#### Observe LiveData with Databinding
It is also very common to observe data from the view. Therefore i'd like to refer to an article about " 
[Use LiveData to notify the UI about data changes](https://developer.android.com/topic/libraries/data-binding/architecture#livedata) "

## T-Shirt App
### Idea
To share the Idea of using LiveData, I created a simple T-Shirt App.  
The App is not realy practical, but the code I used, should show how LiveData can be used.  
To get the basic idea of the App, here are some Screenshots:  
<img src="screenshot_basic.png" alt="drawing" width="200"/>
<img src="multiple_shirts_blue.png" alt="drawing" width="200"/>  
There are 3 Fragments. The First and the second, show the exact same content and behave identical. The only difference between them is the implementation of it. The first, observes the values in the Viewmodel with databinding. The code is written in the xml file of the View. For the second implementation, the code is written in the fragment file itself.  
The first approach is the most common approach.  

The third Fragment, is an overview of T-Shirts in the repository. The details fragment below can be changed by clicking on a t-shirt in the third Fragment. The t-shirts color, the color value and the size will change immediately.  
A LiveData value in the ViewModel will be updated, by clicking on a t-shirt. By updating the value, the observer in the view gets notified and updates its values on its own.

Under the third Fragment is a "Add Random T-Shirt" Button. When it is clicked, a t-shirt with random Hex-Color and Size will be added to the repository. The change in the Repository also will notify all observers and indirect observers and they will change. 

### Architectur:
Here are screenshots, how LiveData fits into the architecture of the app:  
<img src="TShirtAppOverview.png" alt="drawing" width="800"/>  
<img src="TShirtAppDetailView.png" alt="drawing" width="800"/>  

## Summary
* give some hints
* share repo
* share handout
#### Technical background:
* I have worked already with LD in my internship. The very first thing you have to do is to create Views, and fill them with data. (because it is the easies what you can do) Later on, tasks improve, but with this task you will improve you stream based thinking a lot and see some edge cases which come up.
