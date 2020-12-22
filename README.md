# RickAndMorty - Kotlin

![rivkandmorty](https://user-images.githubusercontent.com/75754448/102901222-a7118780-446d-11eb-8eb8-1013796eb76c.png)

The project was created in activities.After clicking on the "tile" you will be taken to the second layout. 

The data was taken from
https://rickandmortyapi.com/api/character/?page=1

<div class="text-white bg-blue mb-2">
bvsbvbsivb
</div>

### Gif's 💡


### Color
The color of the image depend on the characters status, Alive - Green, Dead - Red, Unknown - Gray.

Object created
->
```Kotlin
object RickAndMortyStatus{
fun getStatusColor(status:String) : Int{
    return when(status){
    "unknown" -> R.color.color1
    "Dead" -> R.color.color2
    "Alive" -> R.color.color3
    else -> R.color.Black
}
}
}
```
 And going to RecyclerViewAdapter
 
```Kotlin
viewStatus.setBackgroundColor(ContextCompat.getColor(
context, RickAndMortyStatus.getStatusColor(data.status)
```

The same in SingleCharacterActivity
```Kotlin
imageThumbSingle.setBackgroundColor(
ContextCompat.getColor(
this, RickAndMortyStatus.getStatusColor(it.status)
```

### Data


the data displayed in the first hit in the adapter



