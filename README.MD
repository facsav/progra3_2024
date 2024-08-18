# First Git Project

### Hello from github

## Basic GIT commands

```declarative
    - git status
    - git add .
    - git add ${path/to/file}
    - git commit -m 'some messsage'
    - git checkout -b ${branch-name}
    - git push origin ${branch-name}
```

### Para traer los distintos branches que haya en remoto
```    
    - git pull
```

### Si tengo cambios y no me deja traer lo nuevo desde origin (remoto)
```declarative
    - git stash
    - git pull origin ${branch-name}
    - git stash pop
```

ref: https://www.freecodecamp.org/news/10-important-git-commands-that-every-developer-should-know/