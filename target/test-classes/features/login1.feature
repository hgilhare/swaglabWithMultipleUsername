Feature: practice swaglab framework
@Reg
Scenario Outline: verify swaglab login page

Given user enter "<username>" 
Then user enter password
And user clicked on login button
And user verified sucessful login home

Examples:
|username|
|standard_user|
|locked_out_user|
|problem_user|
|performance_glitch_user|