def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    //自定义code
    echo "Welcome, ${NAME}."
    echo "Let's talk about a story which names ${STORY_NAME}."
    echo "Version is: ${VERSION}."
}