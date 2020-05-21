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
			}  t
## T-Shirt App
* slides
* screenshots
## Summary
* give some hints
* share repo
* share handout
#### Technical background:
* I have worked already with LD in my internship. The very first thing you have to do is to create Views, and fill them with data. (because it is the easies what you can do) Later on, tasks improve, but with this task you will improve you stream based thinking a lot and see some edge cases which come up.
