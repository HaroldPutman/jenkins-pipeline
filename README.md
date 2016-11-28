# jenkins-pipeline

Sample project to explore Jenkins pipeline build.

## How this works

If you want to load files from within your pipeline script, they need to be
checked out on folder that you can access from your node. There may be a way
to configure Jenkins so that `${WORKSPACE}@script` is accessible from every
node, but it is not clear from documentation that this is guaranteed to work.

Instead we checkout the Jenkinsfile into a directory on the node through some
bootstrapping code:

```java
def jenkinsfile

node("linux") {
  deleteDir()
  dir (".script") {
    git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: 'rds'
  }
  jenkinsfile = load '.script/jenkins/main.groovy'
}
jenkinsfile.build()
```

It seems odd to me that the pipeline plugin does not seem to anticipate a
pipeline build that spans many files. But until it does, this does the trick.

If you put the bootstrap code in a Jenkinsfile that you get from SCM you will
end up checking the source out three times (once to ${WORKSPACE}@script on
the master node, another time into `${WORKSPACE}/.script` folder, and a third
time into the `${WORKSPACE}/main` folder). You can eliminate the first checkout
by pasting the bootstrap code right into your Jenkins project.
