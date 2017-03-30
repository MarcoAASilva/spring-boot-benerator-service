# spring-boot-benerator-service

A wrapper exposing Benerator as Spring Service

## Fork your own repo

It's [a bit trickier than expected](http://bitdrift.com/post/4534738938/fork-your-own-project-on-github)

## How upstream works

* Make changes to br.net.neuromancer.cmdline.EntryPoint according to Spring Boot demo Cmdline
* commit changes
* fetch from upstream
    * bash prompt is more reliable for this task


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
    * use theirs as long as changes are on demo-cmdline exclusive package **br.net.neuromancer.cmdline**
    * be careful when merging changes to common files (e.g. pom.xml)
    * TortoiseGit is quite efficient for this task
    

# Roadmap for Benerator Integration

* extract the logic from **org.databene.benerator.main.Benerator**

```java
	public static void runFile(String filename, InfoPrinter printer) throws IOException {
		BeneratorMonitor.INSTANCE.reset();
		MemorySensor memProfiler = MemorySensor.getInstance();
		memProfiler.reset();
		if (printer != null) {
			printer.printLines("Running file " + filename);
			BeneratorUtil.checkSystem(printer);
		}
		BeneratorContext context = BeneratorFactory.getInstance().createContext(IOUtil.getParentUri(filename));
		DescriptorRunner runner = new DescriptorRunner(filename, context);
		try {
			runner.run();
		} finally {
			IOUtil.close(runner);
		}
		BeneratorUtil.logConfig("Max. committed heap size: " + new KiloFormatter(1024).format(memProfiler.getMaxCommittedHeapSize()) + "B");
	}
```

* create *BeneratorSpringWrapper* annotated with [@Component](http://howtodoinjava.com/spring/spring-core/how-to-use-spring-component-repository-service-and-controller-annotations/)
* implement method void *BeneratorSpringWrapper.run(String scriptFilePath)* (use extracted logic)
* @Autowire *BeneratorSpringWrapper* on the Entrypoint 
* create holder *BeneratorParameterStream* String, InputStream
* create @Component *BeneratorFileUtils*
* implement method void createTempFileFromStreams(ArrayList<BeneratorParameterStream>) [inspired here](http://stackoverflow.com/questions/4317035/how-to-convert-inputstream-to-virtual-file)
* inject *BeneratorFileUtils* into *BeneratorSpringWrapper* constructor
* overload void *BeneratorSpringWrapper.run(ArrayList<BeneratorParameterStream>)*
* write tests for everything



