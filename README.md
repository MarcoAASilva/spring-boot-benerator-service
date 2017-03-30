# spring-boot-benerator-service

A wrapper exposing Benerator as Spring Service

## Fork your own repo

It's [a bit trickier than expected](http://bitdrift.com/post/4534738938/fork-your-own-project-on-github)

## How upstream works

* Make changes to br.net.neuromancer.cmdline.EntryPoint according to Spring Boot demo Cmdline
* commit changes
* fetch from upstream


```bash
$ git fetch upstream
remote: Counting objects: 10, done.
remote: Compressing objects: 100% (5/5), done.
remote: Total 10 (delta 2), reused 8 (delta 0), pack-reused 0
Unpacking objects: 100% (10/10), done.
From github.com:NeuromancerNet/spring-boot-demo-cmdline
   ceacc66..fb13d5b  master     -> upstream/master
```

* resolve merge conflicts 
    * TortoiseGit is quite efficient for this task
    * use theirs as long as changes are on demo-cmdline exclusive package **br.net.neuromancer.cmdline**
    * be careful when merging changes to common files (e.g. pom.xml)
    
