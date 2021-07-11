def call(Map pipelineParams) {
    //自定义code
    echo "Welcome, ${pipelineParams.name}."
    echo "Let's talk about a story which names ${pipelineParams.storyName}."
}