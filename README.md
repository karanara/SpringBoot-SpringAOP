Two main Problems: Code Tangling and Code Scattering
Aspect Oriented Programming: 
    Programming technique based on concept of an Aspect
    Aspect encapsulates cross-cutting concern
    Aspects can be used at multiple concerns.
Benefits:
    1.Code for Aspect is defined in a single class
    2. Business code in your application is cleaner
    3.Configurable
AOP Terminology
• Aspect: module of code for a cross-cutting concern (logging, security, …) 
• Advice: What action is taken and when it should be applied 
• Join Point: When to apply code during program execution
• Pointcut: A predicate expression for where advice should be applied.
Advice Types
• Before advice: run before the method
• After finally advice: run after the method (finally)
• After returning advice: run after the method (success execution)
• After throwing advice: run after method (if exception thrown)
• Around advice: run before and after method
Weaving:
• Connecting aspects to target objects to create an advised object
• Different types of weaving
• Compile-time, load-time or run-time 
• Regarding performance: run-time weaving is the slowest
Two AOP frameworks: AspectJ and Spring AOP:
Spring AOP:
      Spring provides AOP support.Key component of Spring.Security, transactions, caching etc .Uses run-time weaving of aspects.
AspectJ
• Original AOP framework, released in 2001
• www.eclipse.org/aspectj
• Provides complete support for AOP
• Rich support for join points: method-level, constructor, field
• code weaving: compile-time, post compile-time and load-time
PointCutExpression :
   Syntax:execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?
   We can use wild card such as *.
   Parameter Pattern Wildcards
   For param-pattern
     • () - matches a method with no arguments
     • (*) - matches a method with one argument of any type
     • (..) - matches a method with 0 or more arguments of any type
    Combine pointcut expressions using logic operators 
     • AND (&&)
     • OR (||)
     • NOT (!)
    Control order on Aspects using the @Order annotation
    We can access Access method Parameters through Method Signature and Method Arguments.


