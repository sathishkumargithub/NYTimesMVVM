# NYTimes Application using MVVM Design pattern 

## Introduction

NYtimes application shows a list of NYTimes most viewed articles. Tapping on the article in a list show a detailed view of the particular 
article.  
* A main activity that handles navigation between articlelistfragment and articledetailfragment.
* A articlelistfragment to display the list of products.
* A articledetailfragment to display a product review.

 Architechture components used in this application are:
1) ViewModel
2) DataBinding
3) LiveData

### Model-View-ViewModel (MVVM) pattern
The app uses a Model-View-ViewModel (MVVM) architecture for the presentation layer. Each of the fragments corresponds to a MVVM View. 
The View and ViewModel communicate using LiveData and the following design principles:

* The View — that informs the ViewModel about the user’s actions
* The ViewModel — exposes streams of data relevant to the View
* The DataModel — abstracts the data source. The ViewModel works with the DataModel to get and save the data.

## DataBinding
Android Data Binding creates a link between UI layer and the underlying data model that holds the information to display.

### Advantages:
1) Data based application can be created quickly and efficiently.
2) Coding size decreases incredibly still you get the desired result.
3) Execution time increases and hence it increases the quality of the application.
4) By using events you can gain control over data binding process.
5) Even if your data is bounded you can modify the coding part easily.
6) Programmers get the benefit of both unbound and bound approach while creating any application.

## LiveData

LiveData is a component which holds the value (data holder) and allows to observe for changes in the value.
It is designed to hold the data in ViewModel.

It uses Observable pattern to detect changes in the data. It’s pretty similar to RxJava observable with the main difference been,
LiveData is lifecycle aware.

The main benefit is the fact that our UI components like RecycleView, 
observe LiveData for changes in the data and LiveData being lifecycle aware it knows about lifecycle of an Activity or Fragment.

#### Instrumentation test using Espresso
 It has simple UI testing like view present (list present), view click and view Id click for recycleview.
 __
 ## License 
 Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 

 
