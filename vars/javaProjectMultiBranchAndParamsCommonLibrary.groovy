def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    
    echo "${pipelineParams.NAME}"
    echo "${pipelineParams.STORY_NAME}"
    echo "${pipelineParams.VERSION}"  

    
}