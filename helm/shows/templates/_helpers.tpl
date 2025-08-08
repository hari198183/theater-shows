{{- define "shows.name" -}}
shows
{{- end -}}

{{- define "shows.fullname" -}}
{{ include "shows.name" . }}
{{- end -}}
